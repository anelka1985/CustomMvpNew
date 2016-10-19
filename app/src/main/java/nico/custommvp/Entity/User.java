package nico.custommvp.Entity;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 作 者: ZhongPin<br>
 * 创建时间: 2014-1-22 上午21:05:35<br>
 * 版权声明: Copyright (C) 2006-2014 <br>
 * 修改历史: 2014-1-22 1.0.0 初始版本<br>
 * 文件描述: 用户类
 */
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String uuid;

    private String authtoken;

    private String imageServer;

    private String picurl;

    private String position;

    private LinkedList<Address> addresses;

    private String background;

    private String name;

    private String job;

    private String duty;

    public int getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(int isOwner) {
        this.isOwner = isOwner;
    }

    private String phone;

    private int isOwner;

    private boolean isSel = false;

    private String communityName;

    private String segmentName;

    private String buildingName;

    private String unitName;

    private String roomName;

    private int registerFlg;

    private String idCard;

    private int type;

    private String province;

    private String city;

    private String area;

    private String nickname;

    private int sex;

    private String signature;

    private int helpCount;

    private int complainCount;

    private int recFmMsg;

    private String uid;

    private String wifiId;

    // 视频sip账号
    private String sip;
    // 视频sip账号密码
    private String sipPwd;

    private String subAccountSid;

    private String subToken;
    /**
     * 是否设置密保答案 0没有设置,1有设置
     */
    private int isHasSecurityAnswer;

    private float totalStar;
    /**
     * 是否显示房产别名,0不显示,1显示
     */
    private int isShowAlias;

    public float getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(float totalStar) {
        this.totalStar = totalStar;
    }

    public int getIsShowAlias() {
        return isShowAlias;
    }

    public void setIsShowAlias(int isShowAlias) {
        this.isShowAlias = isShowAlias;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }


    /**
     * 最后登录时间
     */
    private long lastTime;

    public String getSubAccountSid() {
        return subAccountSid;
    }

    public void setSubAccountSid(String subAccountSid) {
        this.subAccountSid = subAccountSid;
    }

    public String getSubToken() {
        return subToken;
    }

    public void setSubToken(String subToken) {
        this.subToken = subToken;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getImageServer() {
        return imageServer;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public LinkedList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(LinkedList<Address> addresses) {
        this.addresses = addresses;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSel() {
        return isSel;
    }

    public void setSel(boolean isSel) {
        this.isSel = isSel;
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

    public int getRegisterFlg() {
        return registerFlg;
    }

    public void setRegisterFlg(int registerFlg) {
        this.registerFlg = registerFlg;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getHelpCount() {
        return helpCount;
    }

    public void setHelpCount(int helpCount) {
        this.helpCount = helpCount;
    }

    public int getComplainCount() {
        return complainCount;
    }

    public void setComplainCount(int complainCount) {
        this.complainCount = complainCount;
    }

    public int getRecFmMsg() {
        return recFmMsg;
    }

    public void setRecFmMsg(int recFmMsg) {
        this.recFmMsg = recFmMsg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getWifiId() {
        return wifiId;
    }

    public void setWifiId(String wifiId) {
        this.wifiId = wifiId;
    }

    public int getIsHasSecurityAnswer() {
        return isHasSecurityAnswer;
    }

    public void setIsHasSecurityAnswer(int isHasSecurityAnswer) {
        this.isHasSecurityAnswer = isHasSecurityAnswer;
    }
}
