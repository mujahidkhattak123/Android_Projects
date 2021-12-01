package nurssery.plant_nurssery_app_finder.fyp.nurssery_app;
public class Admin {


    private String hostel_name, address, phoneNumber, email, latitude, longitude, gender,imageUri,
            wifiValue,foodValue,electricValue,summerroomValue,electronicValue,eleValue;


    public Admin(String hostel_name, String address, String phoneNumber, String email, String latitude, String longitude, String gender,String imageUri,
                 String wifiValue,String foodValue,String electricValue,String summerroomValue,String electronicValue,String eleValue) {
        this.hostel_name = hostel_name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gender = gender;
        this.imageUri = imageUri;
        this.wifiValue = wifiValue;
        this.foodValue = foodValue;
        this.electricValue = electricValue;
        this.summerroomValue = summerroomValue;
        this.electronicValue = electronicValue;
        this.eleValue = eleValue;

    }

    public Admin() {
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getHostel_name() {
        return hostel_name;
    }

    public void setHostel_name(String hostel_name) {
        this.hostel_name = hostel_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWifiValue() {
        return wifiValue;
    }

    public void setWifiValue(String wifiValue) {
        this.wifiValue = wifiValue;
    }

    public String getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(String foodValue) {
        this.foodValue = foodValue;
    }

    public String getElectricValue() {
        return electricValue;
    }

    public void setElectricValue(String electricValue) {
        this.electricValue = electricValue;
    }

    public String getSummerroomValue() {
        return summerroomValue;
    }

    public void setSummerroomValue(String summerroomValue) {
        this.summerroomValue = summerroomValue;
    }

    public String getElectronicValue() {
        return electronicValue;
    }

    public void setElectronicValue(String electronicValue) {
        this.electronicValue = electronicValue;
    }

    public String getEleValue() {
        return eleValue;
    }

    public void setEleValue(String eleValue) {
        this.eleValue = eleValue;
    }
}
