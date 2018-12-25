package me.ivanfox.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import me.ivanfox.messages.Departures;
import me.ivanfox.messages.Schedule;
import me.ivanfox.services.TrafiController;

public class AirportCommuteIntent implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AirportCommute"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Schedule tram4Schedule = TrafiController.findTram4FromHomeToAirport();

        List<String> tram4 = tram4Schedule.getDepartures().stream()
            .map(Departures::getRemainingMinutes)
            .collect(Collectors.toList());

        String speechText = "Tram number 4 is going to airport... in  " + String.join(", ", tram4.subList(0, 2)) + " minutes";
        return input.getResponseBuilder()
            .withSpeech(speechText)
            .withSimpleCard("HelloWorld", speechText)
            .withReprompt(speechText)
            .build();
    }
}
