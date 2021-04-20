package de.churl.hamstershort

import java.util.*

fun getNewId(repo: LinkRepository): String {
    var id = UUID.randomUUID().toString().substring(0, 5)

    while (repo.findById(id).isPresent) {
        id = UUID.randomUUID().toString().substring(0, 5)
    }

    return id
}
