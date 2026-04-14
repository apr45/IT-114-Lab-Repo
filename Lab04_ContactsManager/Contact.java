class Contact {
    //TODO: Create fields
    private String name, email, phoneNumber;

    //Create constructor
    public Contact(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    //Getters
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    //toString method
    public String toString() {
        //TODO: Return formatted string.
        return "Name: " + name + " | Phone: " + phoneNumber;
    }
}