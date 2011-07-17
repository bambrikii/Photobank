/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bambrikii.site.base.auth.model;

import java.util.Date;
import java.util.List;

import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.model.Phone;

public class User {
	private Integer id;
	private String surname;
	private String firstname;
	private String password;
	private Date modificationTime;
	private String email;
	private String address;
	private Date dateOfBirth;
	private String organization;
	private String sortOfActivity;
	private String about;
	private String passwdSHA1;
	private List<Group> groups;
	private Language language;
	private List<Phone> phones;
	private UserStatusEnum status;
	private String patronymic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganization() {
		return organization;
	}

	public void setSortOfActivity(String sortOfActivity) {
		this.sortOfActivity = sortOfActivity;
	}

	public String getSortOfActivity() {
		return sortOfActivity;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAbout() {
		return about;
	}

	public void setPasswdSHA1(String passwdSHA1) {
		this.passwdSHA1 = passwdSHA1;
	}

	public String getPasswdSHA1() {
		return passwdSHA1;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}

	public UserStatusEnum getStatus() {
		return status;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getPatronymic() {
		return patronymic;
	}
}
