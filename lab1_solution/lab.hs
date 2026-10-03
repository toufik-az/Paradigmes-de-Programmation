import Data.Char (toLower)

quest :: [String]
quest =
  [ "I enjoy going to parties with lots of people."
  , "I find it easy to start conversations with strangers."
  , "I feel comfortable being the center of attention."
  , "I prefer working in a group rather than alone."
  , "I feel more energized after spending time with other people."
  , "I feel more energized after spending time alone."
  , "I prefer listening over talking in group discussions."
  , "I need quiet time to recharge after socializing."
  , "I prefer a quiet night in over a big social event."
  , "I think carefully before speaking in a group."
  ]

count :: [Bool] -> Int
count answers = length (filter (== True) answers)

decide :: [Bool] -> String
decide answers
  | ext > intro = "Extrovert"
  | intro > ext = "Introvert"
  | otherwise = "Balanced (Ambivert)"
  where
    ext = count (take 5 answers)
    intro = count (drop 5 answers)

ask :: Int -> String -> IO Bool
ask n question = do
  putStrLn (show n ++ ". " ++ question ++ " (T/F):")
  answer <- getLine
  case map toLower answer of
    "t" -> return True
    "true" -> return True
    "f" -> return False
    "false" -> return False
    _ -> do
      putStrLn "Please enter T or F."
      ask n question

main :: IO ()
main = do
  putStrLn "Personality Test\n"
  answers <- sequence [ask n question | (n, question) <- zip [1..] quest]
  let ext = count (take 5 answers)
      intro = count (drop 5 answers)
  putStrLn ("\nExtrovert score: " ++ show ext)
  putStrLn ("Introvert score: " ++ show intro)
  putStrLn ("Result: " ++ decide answers)
