package org.bambrikii.kbManager.parser.model;

public class Grammar {
	private int _id;
	public int getId(){
		return _id;
	}
	public void setId(int id){
		_id	= id;
	}

	private String _name;
	public String getName(){
		return _name;
	}
	public void setName(String name){
		_name	= name;
	}
	private String _rules;
	public String getRules(){
		return _rules;
	}
	public void setRules(String rules){
		_rules	= rules;
	}
}