package pl.smerski.siatkowka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.smerski.siatkowka.domain.Player;
import pl.smerski.siatkowka.service.PlayerManager;

@Controller
public class WebPlayerController {
    private final PlayerManager playerManager;

    public WebPlayerController(@Autowired PlayerManager playerManager) {
        this.playerManager = playerManager;
    }
    // Get all players
    @GetMapping("/players")
    public String getPlayers(Model model) {
        model.addAttribute("allPlayersFromDB", playerManager.getPlayers());
        return "players";
    }
    // Post new player
    @GetMapping("/players/form")
    public String getForm(Model model) {
        model.addAttribute("playerToAdd", new Player("", "", 0, 0, ""));
        return "playerForm";
    }

    @PostMapping("/players")
    public String addPlayer(Player playerToBeAdded) {
        playerManager.addPlayer(playerToBeAdded);
        return "redirect:/players";
    }
    // Delete player
    @GetMapping("/players/delete/{id}")
    public String deletePlayer(@PathVariable String id) {
        try {
            playerManager.deletePlayer(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/players";
    }
    // Update player
    @GetMapping("/players/update/{id}")
    public String updatePlayer(@PathVariable String id, Model model) {
        try {
            model.addAttribute("playerToUpdate", playerManager.getPlayer(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "updatePlayer";
    }
}

