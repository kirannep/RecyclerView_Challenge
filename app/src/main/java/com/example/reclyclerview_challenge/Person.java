package com.example.reclyclerview_challenge;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String firstname;
    private String lastname;
    private int age;
    private int salary;

    public Person(String firstname, String lastname, int age, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
    }

    protected Person(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        age = in.readInt();
        salary = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstname);
        parcel.writeString(lastname);
        parcel.writeInt(age);
        parcel.writeInt(salary);
    }
}
