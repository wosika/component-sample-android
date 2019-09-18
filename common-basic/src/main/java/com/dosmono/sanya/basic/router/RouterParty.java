
package com.dosmono.sanya.basic.router;
public interface RouterParty {
    /**
     * 组名
     */
    String APP = "/app";//宿主 App 组件
    String TIANYA = "/tianya";//天涯组件
    String JIYANG = "/jiyang";//吉阳组件

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    String SERVICE = "/service";


    /**
     * 宿主 App 分组
     */
    String APP_MAINACTIVITY = APP + "/MainActivity";


    /**
     * 天涯分组
     */
    String TIANYA_SERVICE_TIANYAINFOSERVICE = TIANYA + SERVICE + "/TIANYAInfoService";

    String TIANYA_HOMEACTIVITY = TIANYA + "/HomeActivity";

    /**
     * 吉阳分组
     */
    String JIYANG_SERVICE_JIYANGINFOSERVICE = JIYANG + SERVICE + "/JIYANGInfoService";

    String JIYANG_HOMEACTIVITY = JIYANG + "/HomeActivity";

}