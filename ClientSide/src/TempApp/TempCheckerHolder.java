package TempApp;

/**
* TempApp/TempCheckerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from TempApp.idl
* Friday, March 5, 2021 7:08:35 o'clock PM BRT
*/

public final class TempCheckerHolder implements org.omg.CORBA.portable.Streamable
{
  public TempChecker value = null;

  public TempCheckerHolder ()
  {
  }

  public TempCheckerHolder (TempChecker initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TempCheckerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TempCheckerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TempCheckerHelper.type ();
  }

}
