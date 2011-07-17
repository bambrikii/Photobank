(function($) {
	$.fn
			.extend({
				photobank_basket_preview : function(options) {
					var defaults = {
						baseUrl : "/photobank/",
						rpcServerUrl : "ajax/basketAjax",
						photoPreviewUrl : "photoPreview!large.action?id=",
						action_add_title : "action.add",
						action_delete_title : "action.delete",
						action_update_title : "action.update",
						action_back_title : "action.back",
						file_description_title : "file.description",
						file_event_title : "event",
						file_insertionTime_title : "file.insertionTime",
						successEvent : function() {

						}
					}
					var options = $.extend(defaults, options);
					return this
							.each(function() {
								var opts = options;
								var obj = $(this);
								obj
										.bind(
												"click",
												function() {
													var url1 = opts.baseUrl
															+ opts.rpcServerUrl
															+ "!preview";
													var data1 = "";
													if (opts.fileId != null) {
														url1 += "File";
														data1 += "fileId="
																+ opts.fileId;
													} else {
														url1 += "Item";
														data1 += "itemId="
																+ opts.itemId;
													}
													url1 += ".action";

													$
															.ajax({
																type : "POST",
																url : url1,
																data : data1,
																context : document.body,
																success : function(
																		data) {

																	var imgElem = "<div style=\"margin: 15 0 15 0;\"><img src=\""
																			+ opts.baseUrl
																			+ opts.photoPreviewUrl
																			+ data["file"]["id"]
																			+ "\" title=\""
																			+ data["file"]["description"]
																			+ "\" class=\"imageItem_Preview\" /></div>";

																	var idElem = "";
																	if (opts.fileId != null) {
																		idElem += "<input type=\"hidden\" name=\"selectedFileId\" value=\""
																				+ data["file"]["id"]
																				+ "\" />";
																	} else {
																		idElem += "<input type=\"hidden\" name=\"selectedItemId\" value=\""
																				+ opts.itemId
																				+ "\" />"
																	}

																	var propElems = "";
																	if (data["file"]["eventName"] != null) {
																		propElems += "<div class=\"win_text\" style=\"margin-bottom: 5px; text-align: left;\">"
																				+ opts.file_event_title
																				+ ": "
																				+ data["file"]["eventName"]
																				+ "</div>";
																	}
																	if (data["file"]["description"] != null) {
																		propElems += "<div class=\"win_text\" style=\"margin-bottom: 5px; text-align: left;\">"
																				+ opts.file_description_title
																				+ ": "
																				+ data["file"]["description"]
																				+ "</div>";
																	}
																	if (data["file"]["date"] != null) {
																		// TODO:
																		// Date
																		// format
																		// is
																		// not
																		// automatically
																		// localized!!!
																		var dates = data["file"]["date"]
																				.split(/[\WT]/);
																		propElems += "<div class=\"win_text\" style=\"margin-bottom: 5px; text-align: left;\">"
																				+ opts.file_insertionTime_title
																				+ ": <span class=\"win_data\">"
																				+ dates[2]
																				+ "."
																				+ dates[1]
																				+ "."
																				+ dates[0]

																				+ "</span></div>";
																	}

																	var sizeElem = "<div class=\"win_text\" style=\"margin-bottom: 5px; text-align: left;\"><select name=\"selectedDimensionId\">";
																	for ( var i = 0; i < data["dimensions"].length; i++) {
																		var dim1 = data["dimensions"][i];
																		sizeElem += "<option value=\""
																				+ dim1.id
																				+ "\""
																				+ (opts.itemId != null
																						&& dim1.id == data["selectedDimensionId"] ? " selected=\"selected\" "
																						: "")
																				+ ">"
																				+ dim1.name
																				+ " / "
																				+ dim1.summary
																				+ "</option>";
																	}
																	sizeElem += "</select>";

																	var divElem = "<table><tr><td style=\"width: 49%;\"><td>"
																			+ idElem
																			+ imgElem
																			+ propElems
																			+ sizeElem
																			+ "</td><td style=\"width: 49%;\"></td></tr></table>";

																	var dialog1 = $(
																			divElem)
																			.dialog(
																					{
																						title : data["file"]["description"],
																						width : 650,
																						position : "top",
																						modal : true,
																						resizable : false,
																						autoResize : true,
																						buttons : {
																							action_add_title : function() {
																								$
																										.ajax({
																											type : "POST",
																											url : opts.baseUrl
																													+ opts.rpcServerUrl
																													+ "!addItem.action",
																											data : "fileId="
																													+ $(
																															"input[name='selectedFileId']",
																															this)
																															.val()
																													+ "&selectedDimensionId="
																													+ $(
																															"select[name='selectedDimensionId']",
																															this)
																															.val(),
																											success : function() {
																												opts
																														.successEvent();
																											},
																											error : function(
																													request,
																													textStatus,
																													ex) {
																												alert("Error: "
																														+ textStatus
																														+ "\n"
																														+ ex
																														+ "\n"
																														+ request.status
																														+ "("
																														+ request.statusText
																														+ " "
																														+ request.responseText
																														+ ")");
																											}
																										});
																								$(
																										this)
																										.dialog(
																												"close");
																							},

																							action_update_title : function() {
																								$
																										.ajax({
																											type : "POST",
																											url : opts.baseUrl
																													+ opts.rpcServerUrl
																													+ "!updateItem.action",
																											data : "itemId="
																													+ $(
																															"input[name='selectedItemId']",
																															this)
																															.val()
																													+ "&selectedDimensionId="
																													+ $(
																															"select[name='selectedDimensionId']",
																															this)
																															.val(),
																											success : function() {
																												opts
																														.successEvent();
																											},
																											error : function(
																													request,
																													textStatus,
																													ex) {
																												alert("Error: "
																														+ textStatus
																														+ "\n"
																														+ ex
																														+ "\n"
																														+ request.status
																														+ "("
																														+ request.statusText
																														+ " "
																														+ request.responseText
																														+ ")");
																											}
																										});
																								$(
																										this)
																										.dialog(
																												"close");
																							},

																							action_back_title : function() {
																								$(
																										this)
																										.dialog(
																												"close");
																							}
																						}
																					});
																	var addButton = $($(
																			"button",
																			dialog1
																					.parent())[0]);
																	var updateButton = $($(
																			"button",
																			dialog1
																					.parent())[1]);
																	if (opts.fileId != null) {
																		addButton
																				.html("<span class=\"ui-button-text\">"
																						+ opts.action_add_title
																						+ "</span>");
																		updateButton
																				.hide();
																	} else {
																		addButton
																				.hide();
																		updateButton
																				.html("<span class=\"ui-button-text\">"
																						+ opts.action_update_title
																						+ "</span>");
																	}

																	$(
																			$(
																					"button",
																					dialog1
																							.parent())[2])
																			.html(
																					"<span class=\"ui-button-text\">"
																							+ opts.action_back_title
																							+ "</span>");
																},
																error : function(
																		request,
																		textStatus,
																		ex) {
																	alert("Error: "
																			+ textStatus
																			+ "\n"
																			+ ex
																			+ "\n"
																			+ request.status
																			+ "("
																			+ request.statusText
																			+ " "
																			+ request.responseText
																			+ ")");
																}
															});

												});
							});
				}
			});
})(jQuery);