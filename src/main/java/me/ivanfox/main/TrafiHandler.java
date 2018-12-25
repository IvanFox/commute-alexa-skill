package me.ivanfox.main;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import me.ivanfox.handlers.AirportCommuteIntent;
import me.ivanfox.handlers.CancelAndStopIntentHandler;
import me.ivanfox.handlers.WorkCommuteIntentHandler;

public class TrafiHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
            .addRequestHandlers(
                new CancelAndStopIntentHandler(),
                new WorkCommuteIntentHandler(),
                new AirportCommuteIntent()
            )
            .withSkillId("amzn1.ask.skill.ceb6a230-aa47-45bc-887c-8819d7a3e7f4")
            .build();
    }


    public TrafiHandler() {
        super(getSkill());
    }
}
