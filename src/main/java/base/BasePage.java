package base;

public class BasePage extends Base{
	public <Tpage extends BasePage> Tpage as(Class<Tpage> tp){
		try{
			return tp.cast(currentPage);
		}
		catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
}
