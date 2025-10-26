package tst;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({TestePartida.class,
     				TestePartidaIntegracao.class, 
	    			TesteTime.class,})
public class SuiteDeTestes {
    
}
