package de.churl.hamstershort

import de.churl.hamstershort.model.Link
import org.springframework.data.repository.CrudRepository
import java.util.*

interface LinkRepository : CrudRepository<Link, UUID> {
    fun getByShorturl(shorturl: String): Link
}
