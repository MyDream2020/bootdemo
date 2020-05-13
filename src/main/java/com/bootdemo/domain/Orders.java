package com.bootdemo.domain;


import java.sql.Timestamp;

/**
 * @author ASUS
 */
public class Orders {

  private int orderId;
  private int userId;
  private String cardId;
  private String userName;
  private int sectionId;
  private int ticketId;
  private byte isAdule;
  private byte isPay;
  private byte isChange;
  private Timestamp createTime;



  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public int getSectionId() {
    return sectionId;
  }

  public void setSectionId(int sectionId) {
    this.sectionId = sectionId;
  }


  public int getTicketId() {
    return ticketId;
  }

  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
  }


  public byte getIsAdule() {
    return isAdule;
  }

  public void setIsAdule(byte isAdule) {
    this.isAdule = isAdule;
  }


  public byte getIsPay() {
    return isPay;
  }

  public void setIsPay(byte isPay) {
    this.isPay = isPay;
  }


  public byte getIsChange() {
    return isChange;
  }

  public void setIsChange(byte isChange) {
    this.isChange = isChange;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
}
