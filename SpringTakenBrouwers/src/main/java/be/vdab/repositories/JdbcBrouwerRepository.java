package be.vdab.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class JdbcBrouwerRepository implements BrouwerRepository {
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert simpleJdbcInsert;
	
	//RowMapper
	private final RowMapper<Brouwer> rowMapper = (resultSet, rowNum) ->
	new Brouwer(resultSet.getLong("id"), resultSet.getString("naam"), 
			new Adres(resultSet.getString("straat"),resultSet.getString("huisnr"),
					resultSet.getInt("postcode"), resultSet.getString("gemeente")), 
			resultSet.getInt("omzet"));
	//RowMapper end
	
	//SQL statements
	private static final String BEGIN_SELECT = "select id, naam, postcode, gemeente, omzet, straat, huisnr from brouwers ";
	private static final String SQL_FIND_ALL = BEGIN_SELECT + "order by naam";
	private static final String SQL_FIND_BY_NAAM = BEGIN_SELECT + "where naam like ? order by naam";
	//SQL statements end

	JdbcBrouwerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("brouwers");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}

	@Override
	public void create(Brouwer brouwer) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", brouwer.getNaam());
		kolomWaarden.put("straat", brouwer.getAdres().getStraat());
		kolomWaarden.put("huisnr", brouwer.getAdres().getHuisNr() );
		kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
		kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
		kolomWaarden.put("omzet", brouwer.getOmzet());
		brouwer.setId(simpleJdbcInsert.executeAndReturnKey(kolomWaarden).longValue());
	}

	@Override
	public List<Brouwer> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return jdbcTemplate.query(SQL_FIND_BY_NAAM, rowMapper, beginNaam + '%');
	}

}