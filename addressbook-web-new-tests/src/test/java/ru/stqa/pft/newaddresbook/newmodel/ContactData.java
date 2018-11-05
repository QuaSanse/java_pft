package ru.stqa.pft.newaddresbook.newmodel;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String adress;
  private String group;

  public ContactData(String firstname,
                     String lastname,
                     String adress,
                     String Group
  ) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.adress = adress;
    this.group = Group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAdress() {
    return adress;
  }

  public String getGroup() {
    return group;
  }
}
