package de.churl.hamstershort

import org.springframework.data.repository.CrudRepository

interface LinkRepository : CrudRepository<Link, String> {

}
