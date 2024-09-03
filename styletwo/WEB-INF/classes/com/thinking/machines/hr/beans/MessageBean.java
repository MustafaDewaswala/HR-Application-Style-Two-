package com.thinking.machines.hr.beans;
public class MessageBean implements java.io.Serializable
{
private String message;
private String heading;
private Boolean generateButtons;
private Boolean generateTwoButtons;
private String buttonOneText;
private String buttonTwoText;
private String buttonOneAction;
private String buttonTwoAction;
public MessageBean()
{
this.message="";
this.heading="";
this.generateButtons=false;
this.generateTwoButtons=false;
this.buttonOneText="";
this.buttonTwoText="";
this.buttonOneAction="";
this.buttonTwoAction="";
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
public void setHeading(String heading)
{
this.heading=heading;
}
public String getHeading()
{
return this.heading;
}
public void setGenerateButtons(Boolean generateButtons)
{
this.generateButtons=generateButtons;
}
public Boolean getGenerateButtons()
{
return this.generateButtons;
}
public void setGenerateTwoButtons(Boolean generateTwoButtons)
{
this.generateTwoButtons=generateTwoButtons;
}
public Boolean getGenerateTwoButtons()
{
return this.generateTwoButtons;
}
public void setButtonOneText(String text)
{
this.buttonOneText=text;
}
public String getButtonOneText()
{
return this.buttonOneText;
}
public void setButtonTwoText(String text)
{
this.buttonTwoText=text;
}
public String getButtonTwoText()
{
return this.buttonTwoText;
}
public void setButtonOneAction(String action)
{
this.buttonOneAction=action;
}
public String getButtonOneAction()
{
return this.buttonOneAction;
}
public void setButtonTwoAction(String action)
{
this.buttonTwoAction=action;
}
public String getButtonTwoAction()
{
return this.buttonTwoAction;
}
}