package android.org.firebasetest;

import android.os.Parcel;
import android.os.Parcelable;

public class Memo implements Parcelable {
    private String memoId;
    private String title;
    private String feeling;
    private String date;
    private String bodyText;
    private String image;
    private String authorId;
    private String groupId;

    private String weather;

    // Default constructor
    public Memo() {
    }

    public Memo(String memoId, String title, String feeling, String date, String bodyText, String image, String authorId, String groupId, String weather) {
        this.memoId = memoId;
        this.title = title;
        this.feeling = feeling;
        this.date = date;
        this.bodyText = bodyText;
        this.image = image;
        this.authorId = authorId;
        this.groupId = groupId;
        this.weather = weather;
    }

    protected Memo(Parcel in) {
        memoId = in.readString();
        title = in.readString();
        feeling = in.readString();
        date = in.readString();
        bodyText = in.readString();
        image = in.readString();
        authorId = in.readString();
        groupId = in.readString();
    }

    public static final Creator<Memo> CREATOR = new Creator<Memo>() {
        @Override
        public Memo createFromParcel(Parcel in) {
            return new Memo(in);
        }

        @Override
        public Memo[] newArray(int size) {
            return new Memo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(memoId);
        dest.writeString(title);
        dest.writeString(feeling);
        dest.writeString(date);
        dest.writeString(bodyText);
        dest.writeString(image);
        dest.writeString(authorId);
        dest.writeString(groupId);
        dest.writeString(weather);
    }

    // Getters and setters
    public String getMemoId() { return memoId; }
    public void setMemoId(String memoId) { this.memoId = memoId; }
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getFeeling() { return feeling; }
    public void setFeeling(String feeling) { this.feeling = feeling; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getBodyText() { return bodyText; }
    public void setBodyText(String bodyText) { this.bodyText = bodyText; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }
    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }
    public String getWeather(){return weather;  }
    public void setWeather(String weather){this.weather = weather;  }
}
