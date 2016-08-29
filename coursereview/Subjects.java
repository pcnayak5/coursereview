package com.example.prashanthc.coursereview;


public class Subjects {
    private int _id;
    private String _subject;
    private String _name;

    public Subjects() {
    }

    public Subjects(String subjectname) {
        this._subject = subjectname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
    public  void  set_name(String _name){
        this._name = _name ;
    }
    public String get_name(){
        return _name;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }

    public int get_id() {
        return _id;
    }

    public String get_subject() {
        return _subject;
    }
}
