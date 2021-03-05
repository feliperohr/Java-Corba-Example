
import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import TempApp.*;


public class TempAppServer {

    public static void main(String[] args) {
         try {

             //done using the base code in java doc:
             // https://docs.oracle.com/javase/7/docs/technotes/guides/idl/jidlExample.html

             // create and initialize the ORB
             ORB orb = ORB.init(args, null);

             // get reference to rootpoa & activate the POAManager
             POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
             rootpoa.the_POAManager().activate();

             // create servant and register it with the ORB
             TempAppImpl tempAppImpl = new TempAppImpl();
             tempAppImpl.setORB(orb);

             // get object reference from the servant
             org.omg.CORBA.Object ref = rootpoa.servant_to_reference(tempAppImpl);
             TempChecker href = TempCheckerHelper.narrow(ref);

             // get the root naming context
             // NameService invokes the name service
             org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
             NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

             // bind the Object Reference in Naming
             NameComponent path[] = ncRef.to_name( "App" );
             ncRef.rebind(path, href);

             System.out.println("Server ready and waiting ...");


             // wait for invocations from clients
             orb.run();


         }catch (Exception e) {
             System.err.println("ERROR: " + e);
             e.printStackTrace(System.out);
         }
    }
}
