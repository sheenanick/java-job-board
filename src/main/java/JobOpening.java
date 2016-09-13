public class JobOpening {

  private String mTitle;
  private String mDescription;
  private String mContact;

  public JobOpening (String title, String description, String contact) {
    mTitle = title;
    mDescription = description;
    mContact = contact;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getContact() {
    return mContact;
  }

}
