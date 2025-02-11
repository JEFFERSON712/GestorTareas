package principal;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "gestor_tareas";
    private static final String COLLECTION_NAME = "tareas";
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDBConnection() {
        try {
            // Conectar a MongoDB
            mongoClient = new MongoClient(HOST, PORT);
            database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
            System.out.println("✅ Conectado a MongoDB correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error al conectar a MongoDB: " + e.getMessage());
        }
    }

    public void insertarTarea(String usuario, String fecha, String asignadaA, String estado) {
        try {
            Document tarea = new Document("usuario", usuario)
                .append("fecha", fecha)
                .append("asignada_a", asignadaA)
                .append("estado", estado);
            collection.insertOne(tarea);
            System.out.println("✅ Tarea insertada correctamente");
        } catch (Exception e) {
            System.err.println("❌ Error al insertar tarea: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("🔌 Conexión cerrada.");
        }
    }

    void insertTask(String tarea, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
