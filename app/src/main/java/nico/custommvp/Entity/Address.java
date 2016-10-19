package nico.custommvp.Entity;

import java.io.Serializable;

/**
 * 作 者: ZhongPin<br>
 * 创建时间: 2014-1-22 上午21:05:35<br>
 * 版权声明: Copyright (C) 2006-2014 <br>
 * 修改历史: 2014-1-22 1.0.0 初始版本<br>
 * 文件描述: 地址类
 */
public class Address implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 地址
     */
    private String address;

    /**
     * 社区名
     */
    private String communityName;

    /**
     * 分区名
     */
    private String segmentName;

    /**
     * 楼名
     */
    private String buildingName;

    /**
     * 单元名
     */
    private String unitName;

    /**
     * 门牌名
     */
    private String roomName;

    /**
     * 社区家庭成员人员uuid
     */
    private String fmUuid;

    /**
     * 社区Uuid
     */
    private String communityUuid;

    /**
     * 二维码参数-分区
     */
    private String b;
    /**
     * 二维码参数-楼栋
     */
    private String f;
    /**
     * 二维码参数-单元
     */
    private String r;
    /**
     * 社区授权码
     */
    private String m;
    /**
     * 密码2
     */
    private String n;
    /**
     * 密码1
     */
    private String d;

    /**
     * 视频sip账号，22位
     */
    private String sip;
    /**
     * 视频sip账号密码
     */
    private String sipPwd;

    /**
     * 分区视频sip账号
     */
    private String s_sip;

    /**
     * 分区视频sip账号密码
     */
    private String s_sipPwd;
    /**
     *
     */
    private String s_subAccountSid;
    private String s_subToken;

    /**
     * 楼栋视频sip账号
     */
    private String b_sip;

    /**
     * 楼栋视频sip账号密码
     */
    private String b_sipPwd;

    private String b_subAccountSid;
    private String b_subToken;
    /**
     * 单元视频sip账号
     */
    private String u_sip;

    /**
     * 单元视频sip账号密码
     */
    private String u_sipPwd;

    private String u_subAccountSid;
    private String u_subToken;
    /**
     * 房产别名
     */
    private String alias;

    private String roomUuid;
    /**
     * 分区uuid
     */
    private String segmentUuid;
    /**
     * 楼栋uuid
     */
    private String buildingUuid;
    /**
     * 单元uuid
     */
    private String unitUuid;
    /**
     * 分区门禁 : 0:无 1:有
     */
    private int s_doorControl;
    /**
     * 门禁类型 : 0 二维码智能门禁控制器 1 二维码智能门禁控制器 （支持联网） 2 二维码智能门禁对讲监控机 3 二维码智能门锁 4
     * 二维码智能门锁（支持联网）
     */
    private int s_doorControlType;
    /**
     * 楼栋门禁 : 0:无 1:有
     */
    private int b_doorControl;
    /**
     *
     */
    private int b_doorControlType;
    /**
     * 单元门禁 : 0:无 1:有
     */
    private int u_doorControl;
    /**
     *
     */
    private int u_doorControlType;
    /**
     * 二维码有效时间，单位分钟
     */
    private int time;

    /**
     * 社区封面图片
     */
    private String background;

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRoomUuid() {
        return roomUuid;
    }

    public void setRoomUuid(String roomUuid) {
        this.roomUuid = roomUuid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getS_sip() {
        return s_sip;
    }

    public void setS_sip(String s_sip) {
        this.s_sip = s_sip;
    }

    public String getS_sipPwd() {
        return s_sipPwd;
    }

    public void setS_sipPwd(String s_sipPwd) {
        this.s_sipPwd = s_sipPwd;
    }

    public String getB_sip() {
        return b_sip;
    }

    public void setB_sip(String b_sip) {
        this.b_sip = b_sip;
    }

    public String getB_sipPwd() {
        return b_sipPwd;
    }

    public void setB_sipPwd(String b_sipPwd) {
        this.b_sipPwd = b_sipPwd;
    }

    public String getU_sip() {
        return u_sip;
    }

    public void setU_sip(String u_sip) {
        this.u_sip = u_sip;
    }

    public String getU_sipPwd() {
        return u_sipPwd;
    }

    public void setU_sipPwd(String u_sipPwd) {
        this.u_sipPwd = u_sipPwd;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFmUuid() {
        return fmUuid;
    }

    public void setFmUuid(String fmUuid) {
        this.fmUuid = fmUuid;
    }

    public String getCommunityUuid() {
        return communityUuid;
    }

    public void setCommunityUuid(String communityUuid) {
        this.communityUuid = communityUuid;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getSipPwd() {
        return sipPwd;
    }

    public void setSipPwd(String sipPwd) {
        this.sipPwd = sipPwd;
    }

    public String getS_subAccountSid() {
        return s_subAccountSid;
    }

    public void setS_subAccountSid(String s_subAccountSid) {
        this.s_subAccountSid = s_subAccountSid;
    }

    public String getS_subToken() {
        return s_subToken;
    }

    public void setS_subToken(String s_subToken) {
        this.s_subToken = s_subToken;
    }

    public String getB_subAccountSid() {
        return b_subAccountSid;
    }

    public void setB_subAccountSid(String b_subAccountSid) {
        this.b_subAccountSid = b_subAccountSid;
    }

    public String getB_subToken() {
        return b_subToken;
    }

    public void setB_subToken(String b_subToken) {
        this.b_subToken = b_subToken;
    }

    public String getU_subAccountSid() {
        return u_subAccountSid;
    }

    public void setU_subAccountSid(String u_subAccountSid) {
        this.u_subAccountSid = u_subAccountSid;
    }

    public String getU_subToken() {
        return u_subToken;
    }

    public void setU_subToken(String u_subToken) {
        this.u_subToken = u_subToken;
    }

    public String getSegmentUuid() {
        return segmentUuid;
    }

    public void setSegmentUuid(String segmentUuid) {
        this.segmentUuid = segmentUuid;
    }

    public String getBuildingUuid() {
        return buildingUuid;
    }

    public void setBuildingUuid(String buildingUuid) {
        this.buildingUuid = buildingUuid;
    }

    public String getUnitUuid() {
        return unitUuid;
    }

    public void setUnitUuid(String unitUuid) {
        this.unitUuid = unitUuid;
    }

    public int getS_doorControl() {
        return s_doorControl;
    }

    public void setS_doorControl(int s_doorControl) {
        this.s_doorControl = s_doorControl;
    }

    public int getS_doorControlType() {
        return s_doorControlType;
    }

    public void setS_doorControlType(int s_doorControlType) {
        this.s_doorControlType = s_doorControlType;
    }

    public int getB_doorControl() {
        return b_doorControl;
    }

    public void setB_doorControl(int b_doorControl) {
        this.b_doorControl = b_doorControl;
    }

    public int getB_doorControlType() {
        return b_doorControlType;
    }

    public void setB_doorControlType(int b_doorControlType) {
        this.b_doorControlType = b_doorControlType;
    }

    public int getU_doorControl() {
        return u_doorControl;
    }

    public void setU_doorControl(int u_doorControl) {
        this.u_doorControl = u_doorControl;
    }

    public int getU_doorControlType() {
        return u_doorControlType;
    }

    public void setU_doorControlType(int u_doorControlType) {
        this.u_doorControlType = u_doorControlType;
    }


}
