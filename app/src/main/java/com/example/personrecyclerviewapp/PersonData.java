package com.example.personrecyclerviewapp;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonData implements Parcelable {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public PersonData(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    protected PersonData(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        age = in.readInt();
        salary = in.readDouble();
    }

    public static final Creator<PersonData> CREATOR = new Creator<PersonData>() {
        @Override
        public PersonData createFromParcel(Parcel in) {
            return new PersonData(in);
        }

        @Override
        public PersonData[] newArray(int size) {
            return new PersonData[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(age);
        parcel.writeDouble(salary);
    }
}
