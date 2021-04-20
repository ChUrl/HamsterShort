package de.churl.hamstershort

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class HamsterShortController(
    private val linkRepo: LinkRepository
) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("links", linkRepo.findAll())

        return "index"
    }

    @PostMapping("/newlink")
    fun newLink(
        @RequestParam("url") url: String,
        @RequestParam("name") name: String
    ): String {

        val link = Link(getNewId(linkRepo), url, name)
        linkRepo.save(link)

        return "redirect:/"
    }

    @PostMapping("/delete/{shorturl}")
    fun deleteLink(@PathVariable("shorturl") shorturl: String): String {
        linkRepo.deleteById(shorturl)

        return "redirect:/"
    }

    @GetMapping("/video/{shorturl}")
    fun redirect(@PathVariable("shorturl") shorturl: String): String {

        val link = linkRepo.findById(shorturl)
        if (link.isEmpty) {
            return "redirect:/"
        }
        val url = link.get().url

        return "redirect:$url"
    }
}
