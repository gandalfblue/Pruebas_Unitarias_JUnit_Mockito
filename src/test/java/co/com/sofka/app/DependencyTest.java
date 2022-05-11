package co.com.sofka.app;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class DependencyTest {

    @Mock
    private SubDependency subDependency;

    @Mock
    private Dependency dependency;

    @Before
    public void setupMock() {
        subDependency = Mockito.mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testSubDependency() {
        Mockito.when(subDependency.getClassName()).thenReturn("hi there 2");

        Assertions.assertEquals("hi there 2", dependency.getSubdepedencyClassName());
    }
}