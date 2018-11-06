package ru.stqa.pft.newaddresbook.newmodel;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String adress;
  private String group;

  public ContactData(
          String id,
          String firstname,
          String lastname,
          String adress,
          String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.adress = adress;
    this.group = group;
  }

  public ContactData(
          String firstname,
          String lastname,
          String adress,
          String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.adress = adress;
    this.group = group;
  }


  public String getId() {
    return id;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", adress='" + adress + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return adress != null ? adress.equals(that.adress) : that.adress == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (adress != null ? adress.hashCode() : 0);
    return result;
  }
}
