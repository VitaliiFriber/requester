package eu.ppf.requester;

import eu.ppf.requester.dto.User;
import eu.ppf.requester.exeptions.UserNotFoundException;
import eu.ppf.requester.http.UserInformationClient;
import picocli.CommandLine;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Spec;
import static picocli.CommandLine.Option;
import static picocli.CommandLine.Model.CommandSpec;

@Command
public class MainClass implements Runnable {
    @Option(names = {"--s", "--server"}, description = "The server url")
    String server;

    @Option(names = {"--u", "--user"}, description = "UserEntity id")
    String userId;

    @Spec
    CommandSpec spec;

    public void run() {

        if (server != null && userId != null) {
            UserInformationClient client = new UserInformationClient();
            User user = null;
            try {
                user = client.getUserInformation(server, userId);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(user);
            System.exit(1);
        } else {
            throw new CommandLine.ParameterException(spec.commandLine(), "Server and userID required!");
        }
    }

    public static void main(String... args) {
        new CommandLine(new MainClass()).execute(args);
    }
}
