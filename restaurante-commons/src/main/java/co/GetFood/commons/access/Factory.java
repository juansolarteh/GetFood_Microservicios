package co.GetFood.commons.access;

import co.GetFood.commons.infra.Utilities;

/**
 * Fabrica que se encarga de instanciar un repositorio concreto
 *
 * @author Libardo, Julio
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia
 IRestauranteRepository
     *
     * @return una clase hija de la abstracción IRepositorioClientes
     */
    public IGetFoodRepository getRepository() {
        String type = Utilities.loadProperty("restaurante.repository");
        if (type.isEmpty()) {
            //type = "default";
            type = "mysql";
        }
        IGetFoodRepository result = null;

        switch (type) {
            case "mysql":
                result = new GetFoodRepositoryImplMysql();
                break;
        }
        return result;

    }
}
