package co.com.sofka.app;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Matchers.anyInt;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    @Test
    public void testSympleVerify(){

        //Nunca se ha ejecutado
        Mockito.verify(dependency, Mockito.never()).getClassNameUpperCase();
        dependency.getClassNameUpperCase();

        //Solo se ha ejecutado una sola vez
        Mockito.verify(dependency, Mockito.times(1)).getClassNameUpperCase();

        //Como minimo se ha ejecutado una vez
        Mockito.verify(dependency, Mockito.atLeast(1)).getClassNameUpperCase();

        //Como maximo se ha ejecutado dos veces
        Mockito.verify(dependency, Mockito.atMost(2)).getClassNameUpperCase();
    }

    @Test
    public void testParameters(){

        //Solo una vez con el parametro 3
        dependency.addTwo(3);

        Mockito.verify(dependency, Mockito.times(1)).addTwo(3);

        //Dos veces con cualquier parametro
        dependency.addTwo(4);

        Mockito.verify(dependency, Mockito.times(2)).addTwo(anyInt());
    }
}
