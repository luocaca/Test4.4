package com.gson;

import java.util.List;

/**
 * 罗擦擦
 */

public class MyProgramGsonBean {
    public String code;
    public String msg;
    public DataBeanX data;

    public static class DataBeanX {


        public PageBean page;

        public static class PageBean {


            public List<DataBean> data;

            public static class DataBean {

                public String id;
                public String createBy;
                public String createDate;
                public String projectFullName;
                public ClerkBean clerk = new ClerkBean();
                public String consumerName;
                public String consumerUserName;
                public String consumerUserPhone;
                public String consumerInfo;
                public String clerkInfo;
                public int loadCarCount;
                public int unReceiptCarCount;
                public String totalAmount;
                public String typeName;

                @Override
                public String toString() {
                    return "DataBean{" +
                            "id='" + id + '\'' +
                            ", createBy='" + createBy + '\'' +
                            ", createDate='" + createDate + '\'' +
                            ", projectFullName='" + projectFullName + '\'' +
                            ", clerk=" + clerk +
                            ", consumerName='" + consumerName + '\'' +
                            ", consumerUserName='" + consumerUserName + '\'' +
                            ", consumerUserPhone='" + consumerUserPhone + '\'' +
                            ", consumerInfo='" + consumerInfo + '\'' +
                            ", clerkInfo='" + clerkInfo + '\'' +
                            ", loadCarCount=" + loadCarCount +
                            ", unReceiptCarCount=" + unReceiptCarCount +
                            ", totalAmount='" + totalAmount + '\'' +
                            ", typeName='" + typeName + '\'' +
                            '}';
                }

                public static class ClerkBean {
                    public String id;

                    public String agentTypeName;
                    public boolean isDirectAgent;
                    public String displayName = "-";
                    public String adminDisplayName;
                    public String displayPhone;

                    @Override
                    public String toString() {
                        return "ClerkBean{" +
                                "id='" + id + '\'' +
                                ", agentTypeName='" + agentTypeName + '\'' +
                                ", isDirectAgent=" + isDirectAgent +
                                ", displayName='" + displayName + '\'' +
                                ", adminDisplayName='" + adminDisplayName + '\'' +
                                ", displayPhone='" + displayPhone + '\'' +
                                '}';
                    }
                }
            }
        }
    }
}
