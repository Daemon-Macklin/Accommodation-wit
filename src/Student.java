public class Student {
    //Name
    // gender
    // car
    // id

    private String name;
    private String gender;
    private boolean car;
    private int id;


        public Student(String name, String gender, boolean car, int id){
            this.setName(name);
            this.setGender(gender);
            this.setCar(car);
            this.setId(id);
    }

    public String toSting(){
            return "Name: " + this.getName() + " Gender: " + this.getGender() + " Car: "
                    + this.isCar() + "ID:" + this.getId();
    }

    public void setName(String name){

        if(this.name == null){
            int maxLength = (name.length() < 30)?name.length():30;
            name = name.substring(0, maxLength);
            this.name = name;
        }
        else{
            if(name.length() < 30){
                this.name = name;
            }
        }
    }

    public void setGender(String gender){
        if(this.gender == null){
            String finalGender = "";
            if((gender == "m") || (gender == "M") || (gender == "male") || (gender == "Male")){
                finalGender = "M";
            }
            else if((gender == "f") || (gender == "F") || (gender == "female") || (gender == "Female")){
                finalGender = "F";
            }
            else{
                finalGender = "Unspecified";
            }
            this.gender = finalGender;
        }
        else{
            String finalGender = this.gender;
            if((gender == "m") || (gender == "M") || (gender == "male") || (gender == "Male")){
                finalGender = "M";
            }
            else if((gender == "f") || (gender == "F") || (gender == "female") || (gender == "Female")){
                finalGender = "F";
            }
            this.gender = finalGender;
        }
    }

    public void setCar(boolean car){
        this.car = car;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public boolean isCar() {
        return this.car;
    }

    public int getId() {
        return this.id;
    }

}
