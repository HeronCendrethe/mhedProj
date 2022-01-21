package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinTenMinEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinTenMinRepository extends PagingAndSortingRepository<CoinTenMinEntity,Integer> {


}
