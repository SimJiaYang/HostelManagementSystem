package com.example.hostelmanagementsystem;

public class SingleRoom extends Room{
    private boolean isFull;
    private String id;

    /**
     * Empty constructor for creating a single room
     */
    protected SingleRoom(){
        isFull = false;
    }

    /**
     * @param roomNumber - Single room number
     * @param roomPrice - Single room Price
     */
    protected SingleRoom(String roomNumber,double roomPrice){
        super(roomNumber,roomPrice);
        isFull = false;
    }

    /**
     * @param id - Person ID for adding to the single room
     * @return False if the single room already full
     */
    @Override
    public boolean addPerson(String  id){
        // If false, then add a new person, because no full
        if(!isFull){
            this.id = id;
        }
        return isFull;
    }

    /**
     * @param id - Person ID to remove from the single room
     * @return True if remove successfully
     */
    public boolean removePerson(String id){
        boolean isExist;
        // If same person, mean it is existed
        isExist = this.id.equals(id);

        // If true, then set the person to null, because has person lived
        if(isExist){
           this.id = null;
           // If remove successfully, then set is full to falsse
           isFull = false;
        }
        return isExist;
    }

    /**
     * @return Either the single room is full or not
     */
    public boolean getIsFull() {
        return isFull;
    }

    /**
     * @return Single room basic information
     */
    @Override
    public String toString() {
        return "SingleRoom{" +
                "isFull=" + isFull +
                ", id='" + id + '\'' +
                '}';
    }
}
