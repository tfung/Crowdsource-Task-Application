package com.CMPUT301F12T07.crowdsource.taskmodeldb;

public class Task { 
	
	/** private variables */
	String _wid;
	long _tid; 
    String _uid;
    String _title;
    String _description; 
    String _dateCreate; 
    String _dateDue;
    String _type;
    int _visibility;
    int _quantity;
    
    /** Empty constructor */
    public Task(){ } 
    
    /** Light weight constructor */
    public Task(String wid, String title){
    	this._wid = wid;
    	this._title = title;
    }

    /** constructor without tid */ 
    public Task(String uid, String title, String description, String dateCreate, 
    		String dateDue, String type, int visibility, int quantity){ 
        this._uid = uid;
        this._title = title;
        this._description = description; 
        this._dateCreate = dateCreate; 
        this._dateDue = dateDue;
        this._type = type;
        this._visibility = visibility;
        this._quantity = quantity;
    }
    
    /** constructor with tid */ 
    public Task( int tid, String uid, String title, String description, String dateCreate, 
    		String dateDue, String type, int visibility, int quantity){ 
    	this._tid = tid;
        this._uid = uid;
        this._title = title;
        this._description = description; 
        this._dateCreate = dateCreate; 
        this._dateDue = dateDue;
        this._type = type;
        this._visibility = visibility;
        this._quantity = quantity;
    }
    
    /** constructor with wid */
    public Task( String wid, int tid, String uid, String title, String description, String dateCreate, 
    		String dateDue, String type, int visibility, int quantity ){
    	this._wid = wid;
    	this._tid = tid;
        this._uid = uid;
        this._title = title;
        this._description = description; 
        this._dateCreate = dateCreate; 
        this._dateDue = dateDue;
        this._type = type;
        this._visibility = visibility;
        this._quantity = quantity;
    	
    }

    /** getter and setter */
    public String get_wid() {
		return _wid;
	}

	public void set_wid(String _wid) {
		this._wid = _wid;
	}

	public long get_tid() {
		return _tid;
	}

	public void set_tid(long _tid) {
		this._tid = _tid;
	}

	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String get_title() {
		return _title;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	public String get_dateCreate() {
		return _dateCreate;
	}

	public void set_dateCreate(String _dateCreate) {
		this._dateCreate = _dateCreate;
	}

	public String get_dateDue() {
		return _dateDue;
	}

	public void set_dateDue(String _dateDue) {
		this._dateDue = _dateDue;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}
	
	public int get_visibility() {
		return _visibility;
	}

	public void set_visibility(int _visibility) {
		this._visibility = _visibility;
	}
	
	public int get_quantity() {
		return _quantity;
	}

	public void set_quantity(int _quantity) {
		this._quantity = _quantity;
	}

}