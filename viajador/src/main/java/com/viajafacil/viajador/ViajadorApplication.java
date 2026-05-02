package com.viajafacil.viajador;

import com.viajafacil.viajador.model.Lugar;
import com.viajafacil.viajador.repository.LugarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ViajadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViajadorApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(LugarRepository repo) {
        return args -> {
            // --- NORTE ---
            // Chihuahua
            repo.save(crearLugar("Barrancas del Cobre", "Chihuahua", 6, 5, "https://picsum.photos/id/1015/400/400", "Majestuoso sistema de cañones en la Sierra Tarahumara."));
            repo.save(crearLugar("Catedral de Chihuahua", "Chihuahua", 2, 4, "https://picsum.photos/id/1016/400/400", "Joya del barroco novohispano del siglo XVIII."));
            repo.save(crearLugar("Restaurante La Calesa", "Chihuahua", 2, 5, "https://picsum.photos/id/102/400/400", "Famoso por los mejores cortes de carne premium del norte."));
            repo.save(crearLugar("Quinta Gameros", "Chihuahua", 3, 5, "https://picsum.photos/id/1018/400/400", "Mansión Art Nouveau, considerada la casa más bella de México."));
            repo.save(crearLugar("Museo de la Revolución", "Chihuahua", 2, 4, "https://picsum.photos/id/1019/400/400", "Antigua casa de Pancho Villa con objetos históricos."));

            // CDMX
            repo.save(crearLugar("Palacio de Bellas Artes", "CDMX", 3, 5, "https://picsum.photos/id/1016/400/400", "Máximo recinto cultural de México con murales históricos."));
            repo.save(crearLugar("Castillo de Chapultepec", "CDMX", 4, 5, "https://picsum.photos/id/1018/400/400", "Único castillo real en América con vistas panorámicas."));
            repo.save(crearLugar("Restaurante El Cardenal", "CDMX", 2, 5, "https://picsum.photos/id/102/400/400", "Tradición gastronómica famosa por sus desayunos clásicos."));
            repo.save(crearLugar("Xochimilco", "CDMX", 4, 4, "https://picsum.photos/id/1021/400/400", "Paseo tradicional en trajinera por canales prehispánicos."));

            // Jalisco
            repo.save(crearLugar("Hospicio Cabañas", "Jalisco", 3, 5, "https://picsum.photos/id/1022/400/400", "Patrimonio de la Humanidad con murales de Orozco."));
            repo.save(crearLugar("Teatro Degollado", "Jalisco", 2, 5, "https://picsum.photos/id/1023/400/400", "Edificio neoclásico del siglo XIX, emblema de Guadalajara."));
            repo.save(crearLugar("Restaurante Karnes Garibaldi", "Jalisco", 1, 5, "https://picsum.photos/id/1024/400/400", "Famoso por su carne en su jugo y servicio ultrarrápido."));

            // --- LLENADO AUTOMÁTICO PARA LOS 32 ESTADOS ---
            String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", 
                                "Coahuila", "Colima", "Durango", "Estado de Mexico", "Guanajuato", "Guerrero", 
                                "Hidalgo", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", 
                                "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", 
                                "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};

            for (String edo : estados) {
                repo.save(crearLugar("Centro Histórico", edo, 3, 5, "https://picsum.photos/id/50/400/400", "Recorrido por los sitios más emblemáticos de la capital."));
                repo.save(crearLugar("Museo de Arte", edo, 2, 4, "https://picsum.photos/id/51/400/400", "Exposición de la riqueza cultural y artística del estado."));
                repo.save(crearLugar("Restaurante Regional", edo, 2, 5, "https://picsum.photos/id/52/400/400", "Los mejores platillos típicos y sabores tradicionales locales."));
                repo.save(crearLugar("Parque Ecológico", edo, 4, 4, "https://picsum.photos/id/53/400/400", "Naturaleza y recreación al aire libre."));
                repo.save(crearLugar("Mercado de Artesanías", edo, 2, 5, "https://picsum.photos/id/54/400/400", "Piezas únicas hechas por manos de artesanos locales."));
                repo.save(crearLugar("Teatro Principal", edo, 2, 4, "https://picsum.photos/id/55/400/400", "Arquitectura histórica y eventos culturales destacados."));
            }
        };
    }

    private Lugar crearLugar(String nombre, String ciudad, int horas, int pop, String url, String desc) {
        Lugar l = new Lugar();
        l.setNombre(nombre);
        l.setCiudad(ciudad);
        l.setDuracionHoras(horas);
        l.setPopularidad(pop);
        l.setImagenUrl(url);
        l.setDescripcion(desc);
        return l;
    }
}