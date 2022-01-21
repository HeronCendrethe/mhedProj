package br.com.smartbot.testesmartbot.repository;

import br.com.smartbot.testesmartbot.entity.CoinFiveMinEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinFiveMinRepository extends PagingAndSortingRepository<CoinFiveMinEntity,Integer> {
}
