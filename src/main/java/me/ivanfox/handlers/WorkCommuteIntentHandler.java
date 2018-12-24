package me.ivanfox.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import me.ivanfox.messages.Departures;
import me.ivanfox.messages.DeparturesResponse;
import me.ivanfox.services.TrafiController;

public class WorkCommuteIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("Departure"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        DeparturesResponse majakaToCentre = TrafiController.findMajakaToCentr();

        List<String> tram4 = majakaToCentre.getSchedules().get(1).getDepartures().stream()
            .map(Departures::getRemainingMinutes)
            .collect(Collectors.toList());



        String speechText = "Tram number 4 is going to work... in  " + String.join(", ", tram4.subList(0, 2)) + " minutes";
        return input.getResponseBuilder()
            .withSpeech(speechText)
            .withSimpleCard("HelloWorld", speechText)
            .withReprompt(speechText)
            .build();
    }
}
