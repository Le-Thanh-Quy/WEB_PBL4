package Model.BO;


import com.google.api.client.auth.oauth2.Credential;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;


public class UploadImage {
    private static UploadImage instance;

    public static UploadImage getInstance() {
        if (instance == null) {
            instance = new UploadImage();
        }
        return instance;
    }

    private UploadImage() {
    }

    private static final String APPLICATION_NAME = "PBL4";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static Credential getCredentials() throws IOException {
        //final NetHttpTransport HTTP_TRANSPORT
//        // Load client secrets.
//        InputStream in = UploadImage.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        if (in == null) {
//            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
//        }
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        Collection<String> elenco = new ArrayList<String>();
        elenco.add("https://www.googleapis.com/auth/drive");
        GoogleCredential credential = null;
        try {
            credential = new GoogleCredential.Builder()
                    .setTransport(HTTP_TRANSPORT)
                    .setJsonFactory(JSON_FACTORY)
                    .setServiceAccountId("pbl4-266@pbl4-331710.iam.gserviceaccount.com")
                    .setServiceAccountScopes(elenco)
                    .setServiceAccountPrivateKey(KeyPR())
                    .setServiceAccountPrivateKeyId("cf1176a64278e57332325a946ad86433c4e64991")
                    .build();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credential;

    }

    public String UpLoadImage(ByteArrayOutputStream out, String folderId, String name) throws IOException, GeneralSecurityException {
        if (out.size() == 0) {
            throw new IOException();
        }

        //1JUy7im4fXDgBkY5cr9NzheZ3WxO_l87m avatar
        //1R7tDcyA3VsrhC96aIe26BqZxPO_fq65w post
        //final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
                .setApplicationName(APPLICATION_NAME)
                .build();

        File fileMetadata = new File();
        fileMetadata.setName(name);
        fileMetadata.setParents(Collections.singletonList(folderId));


        File file = service.files().create(fileMetadata, new ByteArrayContent("",
                out.toByteArray())).setFields("id").execute();


        return "https://drive.google.com/uc?export=view&id=" + file.getId();
    }


    private final static String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----" +
            "\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDieePV/mLXVEIG" +
            "\nWy6JmZ9leAWeClUp10juFBOeGCkOc1GPjW23uyXXb7mMHw5R/yha08jS2YIAfl7L" +
            "\nShVXrT5f5y2yiouYHy5Pnh6gBI4FmdL/Wt/AVD01KlbXY0KrCIkPPnTOhWx1ALCX" +
            "\nhJvXd/zwWZ7/YvGG9Oby+m7z584qNkZ57Es5wA7QGo3FxRkyqe9WFQihaVRK3fhL" +
            "\nudc9tlUzCmsokoyd8C275IUlnGWBxSdDh2UgINmfXO8Czl6BWDUG+8cpzBYsDBs+" +
            "\nFmMVrBwEXsSp+7NpcEgXQd236Byive2oTkT1oWIktgdINwG8Owfhmq6fTC5pxYJw" +
            "\nKzzM7QzdAgMBAAECggEADPLj/l7TLGrGc/dqf6wPU3LLZsKXpXLdb4f+1NBz/Sib" +
            "\nQ8kAj7DNLwDrO9zPtGD8H/CmyrrBxoDzLw40jlowVt/lz+Trf9Oykb326XZxNKvw" +
            "\n8YWIMFvbUbWdbacLegdyJ14OZCYinMWgvdJeGFxQKOGFktEHrGFxbfg4d/drj86w" +
            "\nkFFfm7GN3S+x3UXXrlj062biUO3xU5fteLAmSR3rdbZWUy9nGCOp3apcKBtHyrj/" +
            "\nJC4d8wZT3azYeCFyG9AgTt2rtO0wkam+ppvidPP5DcXkPXxhMOEgdEs9B65sTLEK" +
            "\nOgDPSSzym+9uj5FUnnA+4qvBrtc1usZDCcPc0lhmaQKBgQD7J8aMShOB1jAXsfXi" +
            "\nBViBY/iq66k4rb1Ky0Ger01AA6294NsvKkVnRY3QADmb+U23SkS4s7vgZpU/WUwI" +
            "\nJPPMgEPHl3qm3ZNBKZSr/9JRR/H0gEoXtp2f4YdwMtWMHfsPvV59njjB/Ry4hEDh" +
            "\n48DBbRB7IjC6OubRrVA9XyHT5QKBgQDm2D8WDnVFNPls7jDhwL4oxqIKqD7KGZ+F" +
            "\nOaAGUrJCaM3ri+JGCEd6TZT2/GAiqWfLtxBNNchESbnY5Q+0AQVuCD+0eFXOvJCp" +
            "\no9VipzYtSxeIM7ebtwl46NaU9/YPNENRwywKLpa3YUlUBrBXDWrrxad6/u2JwwcU" +
            "\njUEEHgs1mQKBgQCp1K+x1bVzKn7CxxfZinvaottX2JtJNFK37NGmmCvIibRGnXIZ" +
            "\nZqAfwSyv5jcOfXpL4vCtZPw6NaPefmenajVhp6otoQTTKSmV+qQJ2qdBR0EZcFap" +
            "\nylaz8jE/cWBtqyhF8GugzgjbRGjTbLrjBLsnELUATpJcm8/RIT0NAvNA8QKBgHja" +
            "\nITzk2NQghaxXjtPBWkxyoQa/Sg/4FiFjJ7nntVc7EwMLuqw7TWBkGWasfY/n7GUk" +
            "\nM66YR34ostkwImZ0WmlefCt5DEMtSPbmxKHfNGfF9k3h9W/aBWV9UEmw/uq6y7uU" +
            "\nWAwEk/bxQbhxwAPzDFTep22m5KjIp35E7RLAv9GRAoGATVw7PBjDqqEHgofgbvDG" +
            "\nKRx9jTamm0z1lAkhaxXynYqK4OmIhINahi7RpuphE5HJrtebfiwqaeP4OdwqDTiE" +
            "\nLJXO1ac3Ccyg7Krv0v4D3vOYND54SY7n1dAlHguOjeMGWDyJJUJHH/2LPuPn9GX6" +
            "\nlzddEEowl0+AbpaD3uVNX+Y=" +
            "\n-----END PRIVATE KEY-----\n";

    public static PrivateKey KeyPR() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        // Read in the key into a String
        StringBuilder pkcs8Lines = new StringBuilder();
        BufferedReader rdr = new BufferedReader(new StringReader(PRIVATE_KEY));
        String line;
        while ((line = rdr.readLine()) != null) {
            pkcs8Lines.append(line);
        }

        // Remove the "BEGIN" and "END" lines, as well as any whitespace

        String pkcs8Pem = pkcs8Lines.toString();
        pkcs8Pem = pkcs8Pem.replace("-----BEGIN PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replace("-----END PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");

        // Base64 decode the result

        byte[] pkcs8EncodedBytes = Base64.getDecoder().decode(pkcs8Pem);

        // extract the private key

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privKey = kf.generatePrivate(keySpec);
        return privKey;
    }
}