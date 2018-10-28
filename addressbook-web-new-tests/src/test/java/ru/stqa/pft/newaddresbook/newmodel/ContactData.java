package ru.stqa.pft.newaddresbook.newmodel;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String adress;
  private final String telmobile;
  private final String telwork;
  private final String email;
  private final String birthdaydate;
  private final String birthdaymonth;
  private final String birthdayyear;
  private String group;

  public ContactData(String firstname,
                     String middlename,
                     String lastname,
                     String nickname,
                     String adress,
                     String telmobile,
                     String telwork,
                     String email,
                     String Birthdaydate,
                     String Birthdaymonth,
                     String Birthdayyear,
                     String Group
  )
  {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.adress = adress;
    this.telmobile = telmobile;
    this.telwork = telwork;
    this.email = email;
    this.birthdaydate = Birthdaydate;
    this.birthdaymonth = Birthdaymonth;
    this.birthdayyear = Birthdayyear;
    this.group = Group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAdress() {
    return adress;
  }

  public String getTelmobile() {
    return telmobile;
  }

  public String getTelwork() {
    return telwork;
  }

  public String getEmail() {
    return email;
  }

  public String getBirthdaydate() {
    return birthdaydate;
  }

  public String getBirthdaymonth() {
    return birthdaymonth;
  }

  public String getBirthdayyear() {
    return birthdayyear;
  }

  public String getGroup() {
    return group;
  }
}
