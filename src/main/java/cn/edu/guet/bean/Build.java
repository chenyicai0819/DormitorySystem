package cn.edu.guet.bean;

public class Build {
    private String buid;

    public Build() {
    }

    public Build(String buid) {
        this.buid = buid;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    @Override
    public String toString() {
        return "Build{" +
                "buid='" + buid + '\'' +
                '}';
    }
}
