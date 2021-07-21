package cn.edu.guet.bean;

public class Room {
    private String rId;
    private String buid;
    private int r1;
    private int r2;
    private int r3;
    private int r4;
    private int r5;
    private int r6;
    private int r7;
    private int r8;
    private int bedNo;

    public Room() {
    }

    public Room(String rId, String buid, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int bedNo) {
        this.rId = rId;
        this.buid = buid;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.r6 = r6;
        this.r7 = r7;
        this.r8 = r8;
        this.bedNo = bedNo;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getR3() {
        return r3;
    }

    public void setR3(int r3) {
        this.r3 = r3;
    }

    public int getR4() {
        return r4;
    }

    public void setR4(int r4) {
        this.r4 = r4;
    }

    public int getR5() {
        return r5;
    }

    public void setR5(int r5) {
        this.r5 = r5;
    }

    public int getR6() {
        return r6;
    }

    public void setR6(int r6) {
        this.r6 = r6;
    }

    public int getR7() {
        return r7;
    }

    public void setR7(int r7) {
        this.r7 = r7;
    }

    public int getR8() {
        return r8;
    }

    public void setR8(int r8) {
        this.r8 = r8;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public Room(String rId, String rBed, String buid) {
        this.rId = rId;
        this.buid = buid;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rId='" + rId + '\'' +
                ", buid='" + buid + '\'' +
                ", r1=" + r1 +
                ", r2=" + r2 +
                ", r3=" + r3 +
                ", r4=" + r4 +
                ", r5=" + r5 +
                ", r6=" + r6 +
                ", r7=" + r7 +
                ", r8=" + r8 +
                ", bedNo=" + bedNo +
                '}';
    }
}
