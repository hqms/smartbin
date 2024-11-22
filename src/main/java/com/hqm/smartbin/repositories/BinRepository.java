package com.hqm.smartbin.repositories;

import com.hqm.smartbin.models.Bin;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface  BinRepository extends CrudRepository<Bin, UUID> {
}
