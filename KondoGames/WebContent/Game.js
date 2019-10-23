
'use strict'
{
	
	class Tile
	{
	
		constructor(number)
		{
			this.scale = 100;
			this.number = number;
			this.position = false;
		}
	}
	
	const tile = new Array(16).fill(null);
	
	for (let index = 0 ; index < tile.length ; index ++)
	{	// 16回繰り返し、タイルオブジェクトを生成
		
		tile[index] = new Tile(index + 1);
		
	}	// for end
	
	tile.forEach((array) => {
		console.log(array);
	});

//	for(let i = tile.length - 1; i > 0; i--)
//	{	// タイルをシャッフルする
//		
//    	let j = Math.floor(Math.random() * (i + 1));
//    	let tmp = tile[i];
//    	tile[i] = tile[j];
//    	tile[j] = tmp;
//		
//	}	// for end
	
	let index = 0;
	const field = (new Array(4)).fill(null).map(() => (new Array(4)).fill(null));
	
	for (let column = 0 ; column < 4 ; column ++)
	{	// 列4
		
		let text = "";
		
		for (let row = 0 ; row < 4 ; row ++)
		{	// 行4
			
			field[column][row] = tile[index];
			index ++;
			text += "["+ field[column][row].number +"]";
			
		}	// for end
		
		console.log(text);
		
	}	// for end
	
	checkLogic();
	
	
	
	function checkLogic()
	{
		
		let number = 0;
		let check = true;
		
		for (let column = 0 ; column < 4 ; column ++)
		{	// 列4
		
			for (let row = 0 ; row < 4 ; row ++)
			{	// 行4
				
				console.log("["+ field[column][row].number +"] ; "+ (field[column][row].number - 1 == number));
				
				// 決まった位置にタイルがなければfalse
				if (field[column][row].number - 1 != number)
				{ check = false; }
				
				number ++;
				
			}	// for end
		}	// for end
		
		if (check)
		{ console.log("ゲームクリア！"); }
		
	}	// function end
	
}