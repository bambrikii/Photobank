<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{parameters.pager.records != null}">
	<s:set name="pagerSize" value="10" />
	<table cellspacing="18">
		<s:bean name="org.apache.struts2.util.Counter" id="rowsCounter">
			<s:param name="first" value="0"></s:param>
			<s:param name="last" value="%{parameters.pager.rowsCount - 1}" />
		</s:bean>
		<s:iterator value="%{rowsCounter}" id="row">
			<tr>
				<s:bean name="org.apache.struts2.util.Counter" id="colsCounter">
					<s:param name="first" value="0"></s:param>
					<s:param name="last" value="%{parameters.pager.colsCount - 1}" />
				</s:bean>
				<s:iterator value="%{colsCounter}" id="col">
					<td><s:if
							test="%{parameters.pager.records[#row*parameters.pager.colsCount + #col]!=null}">
							<s:component template="%{parameters.itemTemplate}">
								<s:param name="record"
									value="%{parameters.pager.records[#row*parameters.pager.colsCount + #col]}" />
							</s:component>
						</s:if>
					</td>
				</s:iterator>
			</tr>
		</s:iterator>
	</table>
	<s:if
		test="%{parameters.pager.totalRecordsCount / parameters.pager.rowsCount / parameters.pager.ColsCount > 0}">
		<table cellspacing="1" cellpadding="5"
			class="pager" border="0" align="center">
			<tr>
				<s:bean name="org.apache.struts2.util.Counter" id="pageCounter">
					<s:param name="first" value="0"></s:param>
					<s:param name="last"
						value="%{parameters.pager.totalRecordsCount / parameters.pager.rowsCount / parameters.pager.ColsCount}" />
				</s:bean>

				<s:if test="%{#request.requestedPage>0}">
					<s:a href="%{prevPageLink}">
						<td
							style="padding: 5px; cursor: hand"
							align="center" width="20"><s:url
								id="prevPageLink" action="%{parameters.pagerAction}"
								includeParams="none">
								<s:param name="requestedPage"
									value="%{#request.requestedPage - 1}" />
								<s:param name="searchString" value="%{searchString}" />
								<s:param name="model.id" value="%{model.id}" />
							</s:url> <s:a href="%{prevPageLink}">
								&lt;&lt;
							</s:a></td>
					</s:a>
				</s:if>
				<s:iterator value="%{pageCounter}" id="page">

					<s:if
						test="%{ (#page  < (#request.requestedPage + #pagerSize)
							&& #page  > (#request.requestedPage - #pagerSize))
							|| #page == 0
							|| #page == (parameters.pager.totalRecordsCount / parameters.pager.rowsCount / parameters.pager.ColsCount)
							 }">
						<s:if test="%{#request.requestedPage == #page}">
							<td align="center"
								style="cursor: default; padding: 5px;"><strong
								><s:property value="#page + 1" />
							</strong>
							</td>
						</s:if>

						<s:else>
							<s:a href="%{pagerUrl}" cssClass="pagerActiveLink">
								<td
									style="padding: 5px; cursor: hand"
									align="center" bgcolor=""><s:url
										action="%{parameters.pagerAction}" id="pagerUrl">
										<s:param name="requestedPage" value="%{page}" />
										<s:param name="searchString" value="%{searchString}" />
										<s:param name="model.id" value="%{model.id}" />
									</s:url> <s:a href="%{pagerUrl}" cssClass="pagerActiveLink">
										<s:property value="#page + 1" />
									</s:a></td>
							</s:a>
						</s:else>
					</s:if>
					<s:elseif test="%{#page == (#request.requestedPage + #pagerSize)}">
						<td>...</td>
					</s:elseif>
					<s:elseif test="%{#page == (#request.requestedPage - #pagerSize)}">
						<td>...</td>
					</s:elseif>

				</s:iterator>
				<s:if
					test="%{(parameters.pager.totalRecordsCount / parameters.pager.rowsCount / parameters.pager.ColsCount) > #request.requestedPage}">
					<s:a href="%{nextPageLink}" >
						<td
							style="padding: 5px; cursor: hand"
							align="center" bgcolor="" width="20"><s:url
								id="nextPageLink" action="%{parameters.pagerAction}"
								includeParams="none">
								<s:param name="requestedPage"
									value="%{#request.requestedPage + 1}" />
								<s:param name="searchString" value="%{searchString}" />
								<s:param name="model.id" value="%{model.id}" />
							</s:url> <s:a href="%{nextPageLink}"
								>
									&gt;&gt;
								</s:a></td>
					</s:a>

				</s:if>
			</tr>
		</table>
	</s:if>
</s:if>