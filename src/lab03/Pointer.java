package lab03;

public class Pointer {
    private int segmentID = -1;
    private int address = - 1;
    private boolean allocated = false;


    public int getSegment(){
        return segmentID;
    }

    public void setSegment(int segment){
        this.segmentID = segment;
    }

    public int getAddress(){
        return address;
    }

    public void setAddress(int address){
        this.address = address;
    }

    public boolean isAllocated(){
        return allocated;
    }

    public void setAllocated(boolean allocated){
        this.allocated = allocated;
    }

}
