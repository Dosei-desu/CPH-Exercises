class Keys2
{
  private boolean wDown = false;
  private boolean aDown = false;
  private boolean sDown = false;
  private boolean dDown = false;
  
  public Keys2(){}
  
  public boolean wDown()
  {
    return wDown;
  }
  
  public boolean aDown()
  {
    return aDown;
  }
  
  public boolean sDown()
  {
    return sDown;
  }
  
  public boolean dDown()
  {
    return dDown;
  }
  
  
  
  void onKeyPressed(int ch)
  {
    if(ch == UP)
    {
      wDown = true;
    }
    else if (ch == LEFT)
    {
      aDown = true;
    }
    else if(ch == DOWN)
    {
      sDown = true;
    }
    else if(ch == RIGHT)
    {
      dDown = true;
    }
  }
  
  void onKeyReleased(int ch)
  {
    if(ch == UP)
    {
      wDown = false;
    }
    else if (ch == LEFT)
    {
      aDown = false;
    }
    else if(ch == DOWN)
    {
      sDown = false;
    }
    else if(ch == RIGHT)
    {
      dDown = false;
    }
  }
}
