package clubdeportivo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {

    @Test
    public void GrupoConstructor_nPlazasNegativaOCero_LanzaClubException(){
        assertThrows(ClubException.class,
                () -> new Grupo("test", "test", -1, 0, 1),
                "Con plazas negativas, se deberia lanzar una ClubException.");
        assertThrows(ClubException.class,
                () -> new Grupo("test", "test", 0, 0, 1),
                "Con cero plazas, se deberia lanzar una ClubException.");
    }

    @Test
    public void GrupoConstructor_matriculadosNegativos_LanzaClubException(){
        assertThrows(ClubException.class,
                () -> new Grupo("test", "test", 1, -1, 1),
                "Con matriculados negativos, se deberia lanzar una ClubException");
    }

    @Test
    public void GrupoConstructor_tarifaNegativaOCero_LanzaClubException(){
        assertThrows(ClubException.class,
                () -> new Grupo("test", "test", 1, 0, -1),
                "Con tarifa negativa, se deberia lanzar una ClubException.");
        assertThrows(ClubException.class,
                () -> new Grupo("test", "test", 1, 0, 0),
                "Con tarifa cero, se deberia lanzar una ClubException.");
    }

    @Test
    public void GrupoContructor_MatriculadosMayorQueNPlazas_ThrowsClubException(){
        assertThrows(ClubException.class,
                () -> new Grupo("test", "test", 1, 2, 1),
                "Con matriculados > NPlazas, deberia lanzar CLubException.");
    }

    @Test
    public void GrupoConstructor_ParametrosValidos_NoLanzaClubException(){
        assertDoesNotThrow(() -> new Grupo("test", "test", 5,2,2),
                "Este test no deberia lanzar ninguna excepcion");
    }

    @Test
    public void GetCodigo_DevuelveCodigo() throws ClubException {

        Grupo g = new Grupo("test", "test", 5, 2, 2);

        assertEquals("test", g.getCodigo(), "El codigo debe ser: test.");
    }

    @Test
    public void GetActividad_DevuelveActividad() throws ClubException {

        Grupo g = new Grupo("test", "test", 5, 2, 2);

        assertEquals("test", g.getActividad(), "La actividad debe ser: test.");
    }



}