package lab03;

public class MemoryManager {

    private final Object[] SegmentA = new Object[1000];
    private final Object[] SegmentB = new Object[1000];

    private final boolean[] usedA = new boolean[SegmentA.length];
    private final boolean[] usedB = new boolean[SegmentB.length];


    public void newPointer(Pointer p){
        if (p.isAllocated()){
            IO.println("Warning: Memory leak detected! Pointer was pointing to Segment "
                    + p.getSegment() + ", Address " + p.getAddress());
        }

        for (int i = 0; i < usedA.length; i++){
            if (!usedA[i]){
                p.setSegment(1);
                p.setAddress(i);
                p.setAllocated(true);
                usedA[i] = true;
                return;
            }
        }
        for (int i = 0; i < usedB.length; i++){
            if (!usedB[i]){
                p.setSegment(2);
                p.setAddress(i);
                p.setAllocated(true);
                usedB[i] = true;
                return;
            }
        }
        IO.println("Error, memory is full");
    }


    public void WritePointer(Pointer p, Object value){
        if (p.isAllocated()){
            int adders = p.getAddress();

            if (p.getSegment() == 1) SegmentA[adders] = value;

            else if (p.getSegment() == 2) SegmentB[adders] = value;

        }
        else IO.println("Error, memory location not found");
    }


    public Object ReadPointer(Pointer p){
        if (p.isAllocated()){
            int adders = p.getAddress();

            if (p.getSegment() == 1)return SegmentA[adders];

            else if (p.getSegment() == 2)return SegmentB[adders];
        }
        return null;
    }


    public void SetPointer(Pointer pA, Pointer pB){
        Object val = ReadPointer(pB);
        WritePointer(pA, val);
    }


    public void FreePointer(Pointer p){
        if (p.isAllocated()){
            int adders = p.getAddress();

            if (p.getSegment() == 1){
                SegmentA[adders] = null;
                usedA[adders] = false;
            }
            else if (p.getSegment() == 2) {
                SegmentB[adders] = null;
                usedB[adders] = false;
            }
            p.setSegment(-1);
            p.setAddress(-1);
            p.setAllocated(false);
        }
    }
}
