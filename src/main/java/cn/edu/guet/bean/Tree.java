package cn.edu.guet.bean;

public class Tree {
    private String treeId;
    private String ParentId;
    private String treeName;
    private String treeUrl;
    private String isParent;


    public Tree() {
    }

    public Tree(String treeId, String parentId, String treeName, String treeUrl, String isParent) {
        this.treeId = treeId;
        ParentId = parentId;
        this.treeName = treeName;
        this.treeUrl = treeUrl;
        this.isParent = isParent;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreeUrl() {
        return treeUrl;
    }

    public void setTreeUrl(String treeUrl) {
        this.treeUrl = treeUrl;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeId='" + treeId + '\'' +
                ", ParentId='" + ParentId + '\'' +
                ", treeName='" + treeName + '\'' +
                ", treeUrl='" + treeUrl + '\'' +
                ", isParent='" + isParent + '\'' +
                '}';
    }
}
